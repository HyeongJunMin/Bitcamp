<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<a>calendar!</a>
<!-- 
CalendarController로 부터 받는 매개변수
CustomCalendarUtil:cal - 캘린더 관련 메소드 포함
	-> 요일정보배열, nvl, callist, showPen, two
 -->
 
<div class="calendarWrap" align="center">
	<table class="calendarHeader">
		<tr>
			<td class="calendarHeaderLeft">
				<a href="#none" title="이전 년" id="_showNextMonth" onclick="changeYearAndMonth(1);">
					<img alt="" src="image/btn_pre_p11.gif" style="width: 9px; height: 9px">
				</a>
				<a href="#none" title="이전 월" id="_showNextYear" onclick="changeYearAndMonth(2);">
					<img alt="" src="image/btn_pre.gif" style="width: 9px; height: 9px">
				</a>
			</td>
			<td class="calendarHeaderYearAndMonth">
				<select class="calendarSelect" id="_calendarHeaderYear">
					<c:forEach begin="1990" end="2030" step="1" var="y">
						<option value="${y }">${y }</option>
					</c:forEach>
				</select>년
				<select class="calendarSelect" id="_calendarHeaderMonth">
					<c:forEach begin="1" end="12" step="1" var="m">
						<option value="${m }">${m }</option>
					</c:forEach>
				</select>월
			</td>
			<td class="calendarHeaderRight">
				<a href="#none" title="다음 월" id="_showNextMonth" onclick="changeYearAndMonth(3);">
					<img alt="" src="image/btn_next.gif" style="width: 9px; height: 9px">
				</a>
				<a href="#none" title="다음 년" id="_showNextYear" onclick="changeYearAndMonth(4);">
					<img alt="" src="image/btn_next_p11.gif" style="width: 9px; height: 9px">
				</a>
			</td>
		</tr>
	</table>
	<table class="calendarBodytbl" style="width:75%; height: 50%;">
		<colgroup>
			<col width="300"><col width="300"><col width="300"><col width="300">
			<col width="300"><col width="300"><col width="300">
		</colgroup>
		<thead class="calendarBodytblHead">
		    <tr>
		    	<c:forEach items="${cal.dayNames }" var="d" varStatus="vs">
		    		<td align="center"><c:out value="${d }"></c:out></td>
		    	</c:forEach><!-- 일월화수목금토 -->
			</tr>
		</thead>
		<tbody class="calendarBodytblBody">
		</tbody>
	</table>

</div>
<input type="button" value="달력!" id="btnTest">
<script type="text/javascript">

var currYear = 1;
var currMonth = 1;

$(function(){
	//오늘 날짜 기준으로 달력 결정 및 생성
	var now = new Date();	
	var nowYear = now.getFullYear();
	var nowMon = now.getMonth() + 1;	
	$("#_calendarHeaderYear").val(nowYear).attr("selected","selected");
	$("#_calendarHeaderMonth").val( nowMon ).attr("selected","selected");
	makeCalendar(nowYear, nowMon);
	
	currYear = parseInt( $("#_calendarHeaderYear option:selected").val() );
	currMonth = parseInt( $("#_calendarHeaderMonth option:selected").val() );
	//alert('현재년' + currYear + '  현재월:' + currMonth);
	
	//달력! 버튼을 클릭하면 선택한 년-월에 해당하는 달력을 그려줌
	$("#btnTest").click(function(){
		$(".calendarRow").remove();
		var destYear = $("#_calendarHeaderYear").val();
		var destMonth = $("#_calendarHeaderMonth").val();
		makeCalendar(destYear, destMonth);				
	});
	
	//select 변경 이벤트 발생하면 선택한 년-월에 해당하는 달력을 그려줌
	$(".calendarSelect").change(function(){
		currYear = parseInt( $("#_calendarHeaderYear option:selected").val() );
		currMonth = parseInt( $("#_calendarHeaderMonth option:selected").val() );
		$(".calendarRow").remove();
		makeCalendar(currYear, currMonth);
	});
	
	//버튼을 클릭하면 선택한 년-월에 해당하는 달력을 그려줌
	
	//Ajax 통신을 통해 년-월을 넘겨서 일정정보를 받아 테이블을 만들어주는 함수 
	$("#btnDelInDetail").click(function(){
		alert('삭제버튼');
		//배열 초기화
		var viewData = {};
		//data[키] = 밸류
		viewData["seq"] = '${bbs.seq}';
		
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			url:'bbsdeletepost.do',
			type:'post',
			data:JSON.stringify(viewData),
			success:function(resp){
				//alert(resp);
				if( resp === 1){
					alert('삭제가 완료되었습니다.');
					location.href="bbslist.do";
				}else{
					alert('삭제에 실패했습니다. 다시 시도해 주세요.');
				}
				
			},
			error:function(){
				alert('error');
			}
		});
	});
});

//num 매개변수를 받아 현재 년-월을 변경해주는 메소드
function changeYearAndMonth(num){
	//alert('현재년' + currYear + '  현재월:' + currMonth);
	
	$("#_calendarHeaderYear").removeAttr("selected","selected");
	$("#_calendarHeaderMonth").removeAttr("selected","selected");
	//alert( typeof currYear + ' ' + typeof currMonth);
	//num: 1.년-1 2.월-1 3.월+1 4.년+1 default.현재 년-월(select)
	switch( num ){
	case 1: currYear = ( ( currYear - 1 ) < 1990 )?1990:(currYear - 1); alert('1990년 이하로 설정할 수 없습니다.'); break;
	case 2: 
			if( (currMonth - 1) < 1 ){
				currMonth = 12;
				if( ( currYear - 1 ) < 1990 ){
					alert('1990년 이하로 설정할 수 없습니다.');
				} else{
					currYear = currYear - 1;				
				}
			}else{
				currMonth = currMonth - 1;
			}
			break;
	case 3:
			if( (currMonth + 1) > 12 ){
				currMonth = 1;
				if( ( currYear + 1 ) > 2030 ){
					alert('2030년 이상으로 설정할 수 없습니다.');
					currMonth = 12;
				}else{
					currYear = currYear + 1;
				}
			}else{
				currMonth = currMonth + 1;
			}
			break;
	case 4: currYear = ( ( currYear + 1 ) > 2030 )?2030:(currYear + 1); break;
	default : break;
	}
	
	//설정된 값에 맞게 select 설정
	$("#_calendarHeaderYear").val( currYear ).attr("selected","selected");
	$("#_calendarHeaderMonth").val( currMonth ).attr("selected","selected");
	
	//달력 지우고 새로 그려주기
	$(".calendarRow").remove();
	makeCalendar(currYear, currMonth);
}

//매개변수에 맞는 달력을 그려 주는 메소드
function makeCalendar(year, month){
	//select에 해당하는 년-월을 매개변수로 받아서 날짜 설정
	var now = new Date(year + '-' + month + '-01');
	var dayOfWeek = now.getDay() + 1; //시작요일 설정
	var lastDay = ( new Date(year, month, 0) ).getDate(); //마지막 날짜 설정
	var weeks = ( lastDay / 7 ) + 1;  // 총 주 수를 설정
	
	//시작일 전 빈칸 채우기
	var trDay = document.createElement('tr');
	trDay.setAttribute('class','calendarRow');
	var tdDay = document.createElement('td');
	tdDay.setAttribute('class','tableBlank');
	tdDay.append(' ');		
	for( i = 1 ; i < dayOfWeek ; i++ ){		
		tdDay = document.createElement('td');
		tdDay.setAttribute('class','tableBlank');
		tdDay.append(' ');	
		trDay.append( tdDay );
	}
	
	//날짜 채우기
	//alert('dayOfWeek : ' + dayOfWeek + (typeof dayOfWeek));
	for( i = 1 ; i < lastDay + 1 ; i++ ){
		//console.log( 'i : ' + i + ',  cond:' + (i + dayOfWeek - 1 ) + ',  dayOfWeek : ' + dayOfWeek ) ;
		tdDay = document.createElement('td');
		tdDay.setAttribute('class','tableDay');
		tdDay.append( i );
		trDay.append( tdDay );
		if( (i + dayOfWeek - 1 ) % 7 === 0 && i != lastDay ){
			//7일을 모두 수행했으면 새로운 행 추가
			$(".calendarBodytbl").append(trDay);
			trDay = document.createElement('tr');
			trDay.setAttribute('class','calendarRow');
		}
	}
	//마지막 주 빈칸 채우고 append
	for( i = 0 ; i < ( ( 7 - ((dayOfWeek + lastDay - 1) ) % 7) ) % 7 ; i++ ){
		tdDay = document.createElement('td');
		tdDay.append(' ');	
		trDay.append( tdDay );
	}		
	
	$(".calendarBodytbl").append(trDay);//마지막 주
}

</script>
</html>