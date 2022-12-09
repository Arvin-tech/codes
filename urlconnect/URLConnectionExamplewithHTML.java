package urlconnect;
import java.io.*;
import java.net.*;
import java.awt.Desktop;

public class URLConnectionExamplewithHTML {

	public static void main(String[]args) {
		try {
			char c1='\0';
			char c='\0';
			
			//File Handling variables
			FileOutputStream fs = new FileOutputStream("C:\\SAGUISA-INTPROG32\\TextToHTML.html");
			OutputStreamWriter output = new OutputStreamWriter(fs);
			
			//declare the URL object which points to a page or resource in resource on the World Wide Web
			URL url = new URL("https://store.steampowered.com");
			
			//declare a URLConnection object to establish communication between the URL and this application/program
			URLConnection urlcon = url.openConnection();
			
			//declare an input stream where data is read
			InputStream stream = urlcon.getInputStream();
			int i;
			//read the first byte of data from the input stream; -1 is return if no data retrieved
			i=stream.read();
			
			//loop through read the contents from input stream until no more data received
			while(i != -1) {
				c1 = (char) i;
				c = c1;
				
				//display the content
				System.out.print(c);
				
				//write the retrieved content data to the HTML File
				output.write(c);
				
				//read the next byte of data from the input stream
				i=stream.read();
			}
			output.flush();
			output.close();
			
			//display the HTML File to a browser
			File file = new File("C:\\\\SAGUISA-INTPROG32\\\\TextToHTML.html");
			Desktop.getDesktop().browse(file.toURI());
		}catch(Exception e) {System.out.println(e);}	
		
	
	}
}
