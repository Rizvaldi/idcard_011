/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IdCard.idcard;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MSI 65 SERIES
 */
@org.springframework.stereotype.Controller
public class Controller {
      @RequestMapping("/controller")
    public String inputData(@RequestParam("varNIM") String nimInput,
            @RequestParam("varNama") String namaInput,
            @RequestParam("varDate")
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam("varImage") MultipartFile imgInput,
            Model input
    ) throws IOException{ byte[] img = imgInput.getBytes();
        String encodeImage = Base64.encodeBase64String(img);
        String imageInput = "data:image/png;base64,".concat(encodeImage);
        
          SimpleDateFormat tanggal = new SimpleDateFormat("dd-MM-yyyy");
        String newTanggal = tanggal.format(date);
        
        input.addAttribute("nim", nimInput);
        input.addAttribute("nama", namaInput);
        input.addAttribute("tanggal", newTanggal);
        input.addAttribute("img", imageInput);
        
        return "hasil";
    }
}