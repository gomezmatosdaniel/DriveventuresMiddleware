package DBCUtils;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ToStringUtils {

	
	
		
		public static String toString(Object o) {
			return ToStringBuilder.reflectionToString(o);
		
	}
}
