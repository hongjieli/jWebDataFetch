/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlicaiwangdatafetch;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;

/**
 *
 * @author honli
 */
public class JLiCaiWangDataCrawlerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        LiCaiWangDataCrawler crawler = new LiCaiWangDataCrawler("http://www.chinawealth.com.cn/zzlc/jsp/lccp.jsp");
        crawler.openRootPage();
        
//        final WebClient webClient=new WebClient(BrowserVersion.CHROME);
//        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
//        webClient.getOptions().setJavaScriptEnabled(true);
//        webClient.getOptions().setActiveXNative(false);
//        webClient.getOptions().setCssEnabled(false);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        
        //Open the root page
//        final HtmlPage rootPage=webClient.getPage("http://www.chinawealth.com.cn/zzlc/jsp/lccp.jsp");
//        Thread.sleep(20000);
//        System.out.println(rootPage.asXml());
//        
//        ScriptResult sr = rootPage.executeJavaScript("javascript:Table.controlPage(2,4)");
//        final HtmlPage tmpPage = (HtmlPage) sr.getNewPage();
//        Thread.sleep(5000);
//        System.out.println(tmpPage.asXml());
        
//        webClient.closeAllWindows();
        
    }
    
}
