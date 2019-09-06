package bit.com.a.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author bitcamp88
 *
 */
@Getter
@Setter
@ToString
public class Youtube implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String url;
	private String img;
}
