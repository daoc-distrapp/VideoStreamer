package streamer;

import java.io.IOException;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

public class MainCamaraUdp {

	public static void main(String[] args) throws IOException {
		UdpSendImage udpSend = new UdpSendImage(Constants.UDP_HOST, Constants.UDP_PORT);
		udpSend.start();
		
		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.QQVGA.getSize());// este es el tamaño por defecto
		webcam.open();
		
		while(true) {
			udpSend.queueImage(webcam.getImage());
		}
	}

}
