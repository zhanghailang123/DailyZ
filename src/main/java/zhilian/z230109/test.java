package zhilian.z230109;

import lombok.Getter;

@Getter
public enum test {
    
    ADD_TEST("ADD_TEST", "111"),
    ;

    private String value;
    private String desc;

    test(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
