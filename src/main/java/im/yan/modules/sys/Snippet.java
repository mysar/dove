package im.yan.modules.sys;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Tip:
 * Created by Im.Yan on 2018/4/17.
 */

public class Snippet {


    // 利用模板生成pdf
    public static void fillTemplate() {
        // 模板路径
        String templatePath = "D:/xx.pdf";
        // 生成的新文件路径
        String newPDFPath = "D:/xxs.pdf";
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;

        // 字体设置
        BaseFont bf;
        Font font = null;
        try {
            bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                    BaseFont.NOT_EMBEDDED);//创建字体
            font = new Font(bf, 12);//使用字体


            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();

            ///String[] str = { "123456789", "TOP__ONE男", "男", "1991-01-01", "130222111133338888", "河北省保定市" };

            String[] str = {"闫超晖", "TOP__ONE男", "男", "看1515"};
            int i = 0;
            java.util.Iterator<String> it = form.getFields().keySet().iterator();
            while (it.hasNext()) {
                String name = it.next().toString();
                if (name.matches("[\u4e00-\u9fcc]+")){
                    form.setField(name, str[i++]);
                    form.setFieldProperty(name, "textfont", font, null);
                }
                System.out.println(name);
                form.setField(name, str[i++]);
            }
            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.close();


            Document document = new Document();

//            document.add(new Paragraph("上善若水",font));
            PdfCopy copy = new PdfCopy(document, out);
            document.open();

            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            document.close();

        } catch (IOException e) {
            System.out.println("异常:文件使用中,请先关闭");
        } catch (DocumentException e) {
            System.out.println("异常:DocumentException"+e.getMessage());
        }

    }

    public static void main(String[] args) {
        fillTemplate();
    }
}
