package jcpp.lang;

import jcpp.*;
import java.io.*;
import org.junit.*;

public class InternalErrorTest extends AbstractTest{
	private static ObjectOutputStream os;

	public InternalErrorTest(){
	}

	@BeforeClass
	public static void setUp() throws Exception{
		File file=createOutputFile(InternalErrorTest.class);
		os=new ObjectOutputStream(new FileOutputStream(file));
	}

	@AfterClass
	public static void tearDown() throws Exception{
		os.close();
	}

	@Test
	public void testWrite() throws Exception{
		InternalError cause=new InternalError("This is the cause");
		InternalError exception=new InternalError("The exception to test");
		exception.initCause(cause);
		os.writeObject(exception);	
	}
}