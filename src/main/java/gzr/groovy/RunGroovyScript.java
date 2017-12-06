package gzr.groovy;

import java.util.HashMap;
import java.util.Map;

import groovy.lang.Binding;
import gzr.file.ReadTxt;

/**
 * 运行groovy脚本
 *
 * @author zengrong.gzr
 * @date 2017/12/06
 */
public class RunGroovyScript {
    public static void main(String[] args) {
        GroovyExecutor groovyExecutor = new GroovyExecutor();
        Map<String, String> map = new HashMap<>();
        //设定需要传入的变量
        map.put("name", "gzr");
        Binding binding = new Binding();
        binding.setVariable("map", map);
        //加载脚本文件
        String filePath = "/Users/gaozengrong/gzr/study/src/main/java/gzr/groovy/script.txt";
        String scriptText = String.valueOf(ReadTxt.loadFile(filePath));
        System.out.println(groovyExecutor.execute(binding, scriptText));
    }
}
