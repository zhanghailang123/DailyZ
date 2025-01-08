package com.zhanghl.first.templatepattern;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/6/28 9:38
 */
public class TestGame {

    public static void main(String[] args) {
        FootballGame footballGame = new FootballGame();
        footballGame.play();

        PingPongGame pingPongGame = new PingPongGame();
        pingPongGame.play();
    }
}