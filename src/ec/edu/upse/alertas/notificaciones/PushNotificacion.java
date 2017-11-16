package ec.edu.upse.alertas.notificaciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.json.JsonException;

import org.eclipse.jdt.internal.compiler.parser.Scanner;
import org.springframework.http.ResponseEntity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class PushNotificacion {
	
  
	public ResponseEntity<String> send() throws JsonException {
		 
		JsonObject body = new JsonObject();
		//body.addProperty("to", "cmb6jnt5oAQ:APA91bEXewzmJLFBWeaHtCo3Vbkq_kzixqA3yaa_hRm3VTMyvFeN3S1gOrJMTfK_jNFTOcvjVHqSrU8I5kOSG5iRhSxw9cvnhrVEoUO714XYe0j2dj0AK4-vQuxMKue0oAyOcpjaH5cB");
		 
		JsonObject notification = new JsonObject();
		notification.addProperty("title", "JSA Notification");
		notification.addProperty("body", "Happy Message!");
		
		JsonObject data = new JsonObject();
		
		data.addProperty("user", "mishell");
		data.addProperty("Key-2", "JSA Data 2");
		
		JsonArray registration_ids = new JsonArray();
		//registration_ids.add(new JsonPrimitive("f80xumY7r_E:APA91bEl_oTM92xkO5QTw-bm6vjHxD_fcZ1oj6uWq089vF36oz9_uUyRpWpYC_4m3PJhnPucbK8UkL2mQri9o0W_xtJV8jWnL3Ie9XDerkb5ln2k31rqyv24tG82q5cB9gff0rcLaQzL"));
	    //registration_ids.add(new JsonPrimitive("cmb6jnt5oAQ:APA91bEXewzmJLFBWeaHtCo3Vbkq_kzixqA3yaa_hRm3VTMyvFeN3S1gOrJMTfK_jNFTOcvjVHqSrU8I5kOSG5iRhSxw9cvnhrVEoUO714XYe0j2dj0AK4-vQuxMKue0oAyOcpjaH5cB"));
	    //registration_ids.add(new JsonPrimitive("dFUUSFvcJeU:APA91bHsXKkWMIEg_v1JakwmZwUbmMuRFhQ1VdIiiUU8P_h7ql6YN5I9qPgwwxEK8WzP5-yKLf03Z9ChQc5BWrXCp54R4e00_kE0h-P_Is5PKuRXIRVKlnYhs4u8DwJMIhnCf3FRLfQ_"));
	    //registration_ids.add(new JsonPrimitive("cP-m1yZcCJg:APA91bGYUbbtzmA0Y0aY-pAhFfIWS3hKTlRu3KJLI368KPMAJuVRDWHiD5dJ0IRICESeFHRjOMjOQsIH0_xAeHYASwZN5aJihKE93pH5-Jtp4Yew1Gw3elZDAxocQOF7W5vEuIMf4B_T"));	
		registration_ids.add(new JsonPrimitive("dfoxhTkpJmE:APA91bEdtfWeMv5b1_J-wKRqLoFtrl_wQn9pxYUgV9FVVaLbRlU6IjHfVORAdQtUB1yT7r0iJt1rNz__odCS95diyrqLeJA_cT4CK0-2jJL7ggindgZ_pemHsX-GhdQWkEGnHysOfWUc"));
		body.add("notification", notification);
		body.add("data", data);
		body.add("registration_ids", registration_ids);
		HttpEntity<String> request = new HttpEntity<>(body.toString());
 
		CompletableFuture<String> pushNotification = AndroidPushNotificationsService.send(request);
		CompletableFuture.allOf(pushNotification).join();
 
		try {
			String firebaseResponse = pushNotification.get();
			
			return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
 
		return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<String> sendUsuario(String usuario) throws JsonException {
		 
		JsonObject body = new JsonObject();
		//body.addProperty("to", "cmb6jnt5oAQ:APA91bEXewzmJLFBWeaHtCo3Vbkq_kzixqA3yaa_hRm3VTMyvFeN3S1gOrJMTfK_jNFTOcvjVHqSrU8I5kOSG5iRhSxw9cvnhrVEoUO714XYe0j2dj0AK4-vQuxMKue0oAyOcpjaH5cB");
		 
		JsonObject notification = new JsonObject();
		notification.addProperty("title", "Alerta!");
		notification.addProperty("body", usuario+ " tiene una Emergia");
		
		JsonObject data = new JsonObject();
		
		data.addProperty("user", "mishell");
		data.addProperty("Key-2", "JSA Data 2");
		
		JsonArray registration_ids = new JsonArray();
		registration_ids.add(new JsonPrimitive("f80xumY7r_E:APA91bEl_oTM92xkO5QTw-bm6vjHxD_fcZ1oj6uWq089vF36oz9_uUyRpWpYC_4m3PJhnPucbK8UkL2mQri9o0W_xtJV8jWnL3Ie9XDerkb5ln2k31rqyv24tG82q5cB9gff0rcLaQzL"));
	    registration_ids.add(new JsonPrimitive("cmb6jnt5oAQ:APA91bEXewzmJLFBWeaHtCo3Vbkq_kzixqA3yaa_hRm3VTMyvFeN3S1gOrJMTfK_jNFTOcvjVHqSrU8I5kOSG5iRhSxw9cvnhrVEoUO714XYe0j2dj0AK4-vQuxMKue0oAyOcpjaH5cB"));
	    registration_ids.add(new JsonPrimitive("dFUUSFvcJeU:APA91bHsXKkWMIEg_v1JakwmZwUbmMuRFhQ1VdIiiUU8P_h7ql6YN5I9qPgwwxEK8WzP5-yKLf03Z9ChQc5BWrXCp54R4e00_kE0h-P_Is5PKuRXIRVKlnYhs4u8DwJMIhnCf3FRLfQ_"));
	    registration_ids.add(new JsonPrimitive("cP-m1yZcCJg:APA91bGYUbbtzmA0Y0aY-pAhFfIWS3hKTlRu3KJLI368KPMAJuVRDWHiD5dJ0IRICESeFHRjOMjOQsIH0_xAeHYASwZN5aJihKE93pH5-Jtp4Yew1Gw3elZDAxocQOF7W5vEuIMf4B_T"));	
		body.add("notification", notification);
		body.add("data", data);
		body.add("registration_ids", registration_ids);
		HttpEntity<String> request = new HttpEntity<>(body.toString());
 
		CompletableFuture<String> pushNotification = AndroidPushNotificationsService.send(request);
		CompletableFuture.allOf(pushNotification).join();
 
		try {
			String firebaseResponse = pushNotification.get();
			
			return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
 
		return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	}
}
