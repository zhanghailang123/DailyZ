package zhilian.z2024;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ZipUtil;
import cn.hutool.http.HttpUtil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author hailang.zhang
 * @since 2024-07-22
 */
public class TestZip {

    private static final String TEMP_FILE = "TEMP_";
    private static final Long SINGLE_FILE_SIZE_5 = 5 *1024 * 1024L;

    public static void main(String[] args) throws IOException {
        File tempFile = File.createTempFile(TEMP_FILE, ".zip");
        HttpUtil.downloadFile("https://storage-public.zhaopin.cn/innovation/gig/1721627601322280899/%25E5%25B7%25A5%25E8%25B5%2584%25E6%2588%2590%25E6%259C%25AC%25E4%25BB%2598%25E6%25AC%25BE%25E8%25A1%25A8%25E5%25AF%25BC%25E5%2585%25A5%25E6%25A8%25A1%25E6%259D%25BF.zip", tempFile);
//        List<String> list = ZipUtil.listFileNames(new ZipFile(tempFile.getPath()), "/");
//        System.out.println(list);
        try (FileInputStream fis = new FileInputStream(tempFile);
             ZipInputStream zis = new ZipInputStream(fis, Charset.forName("GBK"))) {

            int fileCount = 0;
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();
                long fileSize = entry.getSize(); // 文件大小，如果有的话

                // 处理文件名和文件大小等信息
                System.out.println("File #" + (++fileCount) + ": " + fileName + " (" + fileSize + " bytes)");

                extractFile(zis, "C:\\Users\\shi.pengfei\\IdeaProjects\\DailyZ\\src\\main\\java\\zhilian\\z2024\\" + fileName);
                // 关闭当前 entry，准备处理下一个 entry
                zis.closeEntry();
            }

            System.out.println("Total files: " + fileCount);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            tempFile.delete();
        }
    }

    // 解压缩单个文件
    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[4096];
        int read;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}