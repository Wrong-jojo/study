package gzr.groovy;

import com.alibaba.fastjson.JSON;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

/**
 * 运行groovy脚本
 *
 * @author zengrong.gzr
 * @date 2017/12/06
 */
public class GroovyExecutor {

    /**
     * groovy脚本执行器
     *
     * @param binding
     * @param scriptText
     * @return
     */
    public String execute(Binding binding, String scriptText) {
        GroovyShell groovyShell = new GroovyShell(this.getClass().getClassLoader(), binding);
        Object o = groovyShell.evaluate(scriptText);
        return JSON.toJSONString(o);
    }

}
