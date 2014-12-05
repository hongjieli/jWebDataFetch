/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlicaiwangdatafetch;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author honli
 */
public class LiCaiWangDataCrawler {
    final int PAGENUMBER = 7;
    
    private String rootURL;
    private WebClient webClient;

    public LiCaiWangDataCrawler(String rootURL) {
        this.rootURL = rootURL;
        
        //Init webClient
        webClient = new WebClient(BrowserVersion.CHROME);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
    }
    
    public void openRootPage(){
        HtmlPage rootPage = null;
        try {
            rootPage = webClient.getPage(this.getRootURL());
        } catch (IOException ex) {
            Logger.getLogger(LiCaiWangDataCrawler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FailingHttpStatusCodeException ex) {
            Logger.getLogger(LiCaiWangDataCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LiCaiWangDataCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Logger.getLogger(LiCaiWangDataCrawler.class.getName()).log(Level.INFO, rootPage.asXml());
        
        List<DomElement> pageDomList = rootPage.getElementsByIdAndOrName("page");
                
        if( pageDomList.size() != 1){
            Logger.getLogger(LiCaiWangDataCrawler.class.getName()).log(Level.SEVERE, "Error: " + pageDomList.size() + " page found. Expect only one page.\n");
            exit(1);
        }else{
            Logger.getLogger(LiCaiWangDataCrawler.class.getName()).log(Level.INFO, pageDomList.size() + " page found\n");
            DomElement pageElement = pageDomList.get(0);
            
            int index = 0;
            for (DomElement subElement : pageElement.getChildElements()){
                if(index == PAGENUMBER){
                    Logger.getLogger(LiCaiWangDataCrawler.class.getName()).log(Level.INFO, "xx i have ln= " + subElement.getLocalName()+ " \t text = " + subElement.getTextContent());
                }
                index ++;               
            }
        }
    }
    
    public void destroy(){
        this.webClient.closeAllWindows();
        this.webClient = null;
    }

    public String getRootURL() {
        return rootURL;
    }

    public void setRootURL(String rootURL) {
        this.rootURL = rootURL;
    }

}
