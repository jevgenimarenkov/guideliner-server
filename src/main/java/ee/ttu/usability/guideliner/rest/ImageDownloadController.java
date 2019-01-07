package ee.ttu.usability.guideliner.rest;

import org.springframework.web.bind.annotation.*;
import ee.ttu.usability.guideliner.util.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@CrossOrigin(maxAge = 3600)
public class ImageDownloadController {

    @RequestMapping(value = "/downloadImage", method = RequestMethod.GET)
    public void downloadImage(HttpServletRequest request,
                              HttpServletResponse response, @RequestParam String name) throws IOException {
        int BUFFER_SIZE = 4096;
        // get the absolute path of the application
        ServletContext context = request.getSession().getServletContext();        // construct the complete absolute path of the file
        File downloadFile = new File(Configuration.reportsFolder + "/" + name);
        FileInputStream inputStream = new FileInputStream(downloadFile);
        // get MIME type of the file
        String mimeType = context.getMimeType(Configuration.reportsFolder + "/screen1474980098829.0.png" + name);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        // check the mime type
        // set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // get output stream of the response
        OutputStream outStream = response.getOutputStream();
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outStream.close();
    }
}
