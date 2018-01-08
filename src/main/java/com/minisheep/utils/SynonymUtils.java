package com.minisheep.utils;

import com.minisheep.config.IndexConfig;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.synonym.SynonymFilterFactory;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.util.FilesystemResourceLoader;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by minisheep on 18/1/8.
 * 同义词模块
 */
public class SynonymUtils {
    public static String analyzerChinese(String input,boolean userSmart) throws IOException {
        StringBuffer sb = new StringBuffer();
        StringReader reader = new StringReader(input.trim());
        IKSegmenter ikSeg = new IKSegmenter(reader,userSmart);  //true智能分词,false细粒度
        for(Lexeme lexeme = ikSeg.next(); lexeme != null; lexeme = ikSeg.next()){
            sb.append(lexeme.getLexemeText()).append(" ");
        }
        return sb.toString();
    }

    /**
     *
     * 此方法描述的是：针对上面方法拆分后的词组进行同义词匹配，返回TokenStream
     */
    public static TokenStream convertSynonym(String input) throws IOException{
        Version ver = Version.LUCENE_46;
        Map<String, String> filterArgs = new HashMap<String, String>();
        filterArgs.put("luceneMatchVersion", ver.toString());
        filterArgs.put("synonyms", IndexConfig.SYNONYM_URL);
        filterArgs.put("expand", "true");
        SynonymFilterFactory factory = new SynonymFilterFactory(filterArgs);
        FilesystemResourceLoader loader = new FilesystemResourceLoader();
        factory.inform(loader);
        Analyzer whitespaceAnalyzer = new WhitespaceAnalyzer(ver);
        TokenStream ts = factory.create(whitespaceAnalyzer.tokenStream("someField", input));
        return ts;
    }

    /**
     *
     * 此方法描述的是：将tokenstream拼成一个特地格式的字符串，交给IndexSearcher来处理
     */
    public static String displayTokens(TokenStream ts) throws IOException
    {
        StringBuffer sb = new StringBuffer();
        CharTermAttribute termAttr = ts.addAttribute(CharTermAttribute.class);
        ts.reset();
        while (ts.incrementToken())
        {
            String token = termAttr.toString();
            sb.append(token).append(" ");
            System.out.print(token+"|");
//          System.out.print(offsetAttribute.startOffset() + "-" + offsetAttribute.endOffset() + "[" + token + "] ");
        }
        System.out.println();
        ts.end();
        ts.close();
        return sb.toString();
    }

//    public static void main(String[] args) {
//        String indexPath = "/Users/minisheep/Documents/testindex";   //迁移时修改
//        String input = "厦门到沈阳的飞机什么时候能飞离?";
//        System.out.println("**********************");
//        try {
//            String result = displayTokens(convertSynonym(analyzerChinese(input, true)));
//            //CreateIndex.createIndex(indexPath);  //建立索引
//            System.out.println("result:"+ result);
//            List<String> docs = MySearch.searchIndex(result, indexPath);
//            for (String string : docs) {
//                //这个可以获取结果:比如厦门到沈阳的飞机何时起飞(所有跟起飞有关的同义词可归为此类,并且厦门到沈阳可以动态改变,其他不变)
//                System.out.println(string);
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
}
