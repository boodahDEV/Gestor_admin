package recursos;

import java.io.FileInputStream;
import java.io.IOException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.*;
import com.google.firebase.auth.*;



public class Firebase_admin {
	 
	public Firebase_admin() throws IOException, FirebaseAuthException {
		FileInputStream refreshToken = new FileInputStream(System.getenv().get("opciones"));

		FirebaseOptions options = new FirebaseOptions.Builder()
			    .setCredentials(GoogleCredentials.fromStream(refreshToken))
			    .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
			    .build();
		
		FirebaseApp.initializeApp(options);
	}
	
	public void recupera() throws FirebaseAuthException {
		UserRecord userRecord = FirebaseAuth.getInstance().getUser("-LiLYfiWdRj8i0yv8cty");
		// See the UserRecord reference doc for the contents of userRecord.
		System.out.println("Successfully fetched user data: " + userRecord.getEmail());
	}
	public static void main(String args[]) {
		try {
			//System.out.println(System.getenv().get("opciones"));
			new Firebase_admin().recupera();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
