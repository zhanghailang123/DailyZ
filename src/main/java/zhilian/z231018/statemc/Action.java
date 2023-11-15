package zhilian.z231018.statemc;

/**
 * @author hailang.zhang
 * @since 2023-10-31
 */
public interface Action <S, E, C>{

    void execute(S from, S to, E event, C context);
}
