package im.yan.modules.sys;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 打印pdf
 */
public class SnippetPrint { //Print

    private static final Logger logger = LoggerFactory.getLogger(SnippetPrint.class);

    public static void editPdfTemplate(String templateFile, String outFile) throws DocumentException, IOException {
        PdfReader reader = null;   // 模版文件目录
        try {
            reader = new PdfReader(templateFile);
        } catch (IOException e) {
            logger.error("读取PDF模板错误:{}");
            e.printStackTrace();
        }
        PdfStamper ps = new PdfStamper(reader, new FileOutputStream(outFile));
        ; // 生成的输出流
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont("/static/fonts/simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (Exception e) {
            logger.error("字体获取失败:{}");
            e.printStackTrace();
        }

        AcroFields s = ps.getAcroFields();


        //设置文本域表单的字体
        // 对于模板要显中文的，在此处设置字体比在pdf模板中设置表单字体的好处：
        // 1.模板文件的大小不变
        // 2.字体格式满足中文要求
        List<String> list = new ArrayList<>();
        s.setFieldProperty("a", "textfont", bf, null);
        s.setFieldProperty("b", "textfont", bf, null);
        s.setFieldProperty("c", "textfont", bf, null);
        s.setFieldProperty("d", "textfont", bf, null);
        //编辑文本域表单的内容
        s.setField("a", "闫超晖");
        s.setField("b", "cfc测试相似性呢快");
        s.setField("c", "111");
        s.setField("d", "模版文件目录");


        Image image = Image.getInstance("D:\\images\\ico\\100x100.png");
        //float documentWidth = s.ge().getWidth() - document.leftMargin() - document.rightMargin();
        //float documentHeight = documentWidth / 580 * 320;//重新设置宽高
        //image.scaleAbsolute(documentWidth, documentHeight);//重新设置宽高

        // key值
        String fieldName = "c";
        // 通过域名获取所在页和坐标，左下角为起点
        int pageNo = s.getFieldPositions(fieldName).get(0).page;
        Rectangle signRect = s.getFieldPositions(fieldName).get(0).position;
        float x = signRect.getLeft();
        float y = signRect.getBottom();

        // 获取操作的页面
        PdfContentByte under = ps.getOverContent(pageNo);
        // 根据域的大小缩放图片
        image.scaleToFit(signRect.getWidth(), signRect.getHeight());
        // 添加图片
        image.setAbsolutePosition(x, y);
        under.addImage(image);

        ps.setFormFlattening(true); //如果为false那么生成的PDF文件还能编辑，一定要设为true
        ps.close();
        reader.close();
    }

    public static void main(String[] args) throws IOException, DocumentException {
        String templateFile = "D:/xx.pdf";
        String outFile = "D:/xxs.pdf";
        editPdfTemplate(templateFile, outFile);
    }
}
