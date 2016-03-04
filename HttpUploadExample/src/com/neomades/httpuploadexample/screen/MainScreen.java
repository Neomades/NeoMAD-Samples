package com.neomades.httpuploadexample.screen;

import java.io.IOException;
import java.io.InputStream;

import com.neomades.app.ResManager;
import com.neomades.app.Screen;
import com.neomades.httpuploadexample.Res;
import com.neomades.httpuploadexample.service.PostMultipartFormDataService;
import com.neomades.io.http.HttpListener;
import com.neomades.io.http.HttpRequest;
import com.neomades.io.http.HttpResponse;
import com.neomades.ui.Button;
import com.neomades.ui.TextLabel;
import com.neomades.ui.View;
import com.neomades.ui.dialog.WaitDialog;
import com.neomades.ui.listeners.ClickListener;
import com.neomades.util.IOUtils;

public final class MainScreen extends Screen {

	private static final String HTTP_POST_URL = "http://neomades.com/examples/http_upload_example.php";

	private TextLabel uploadResult;

	protected void onCreate() {
		setTitle(Res.string.HTTP_UPLOAD_EXAMPLE);
		setContent(Res.layout.MAIN_SCREEN);

		final Button uploadButton = (Button) findView(Res.id.UPLOAD_BUTTON);
		uploadResult = (TextLabel) findView(Res.id.UPLOAD_RESULT);

		// When the button is clicked, display a wait dialog and launch the
		// upload of the file.
		uploadButton.setClickListener(new ClickListener() {

			public void onClick(View view) {
				uploadFile();
			}
		});
	}

	private void uploadFile() {
		WaitDialog wait = new WaitDialog();
		wait.setMessage(Res.string.UPLOADING);
		controller.showDialog(wait);

		// Create the service that will do the upload.
		PostMultipartFormDataService postService = new PostMultipartFormDataService(HTTP_POST_URL, new HttpListener() {
			public void onHttpResponse(final HttpRequest request, final HttpResponse response) {
				controller.runOnUiThread(new Runnable() {
					public void run() {
						showResults(response.getDataString());
					}
				});
			};
		});

		// Add the two files to upload.
		final String file1 = "logo_neomades_48x48.png";
		InputStream is1 = ResManager.getResourceAsStream(file1);
		postService.addPart("file1", file1, IOUtils.toByteArray(is1));

		final String file2 = "logo_neomades_68x68.png";
		InputStream is2 = ResManager.getResourceAsStream(file2);
		postService.addPart("file2", file2, IOUtils.toByteArray(is2));

		// Launch the upload.
		try {
			postService.upload();
		} catch (IOException e) {
			uploadResult.setText(e.getMessage());
		}
	}

	// When the upload is finished, display the result and hide the wait
	// dialog.
	private void showResults(String text) {
		uploadResult.setText(text);
		controller.hideDialog();
	}
}
