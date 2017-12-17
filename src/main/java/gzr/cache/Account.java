package gzr.cache;

import lombok.Data;

/**
 * @author zengrong.gzr
 * @date 2017/12/17
 */
@Data
public class Account {
    private int id;
    private String name;

    public Account(String name) {
        this.name = name;
    }
}
