import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class GameTetris {
	final String TITLE_OF_PROGRAM = "Tetris";
	final int BLOCK_SIZE = 25;
	final int ARC_RADIUS = 6;
	final int FIELD_WIDTH = 10;
	final int FIELD_HEIGTH = 18;
	final int START_LOCATION = 100;
	final int FIELD_DX = 7;
	final int FIELD_DY = 26;
	final int LEFT = 17;
	final int UP = 38;
	final int RIGHT = 39;
	final int DOWN = 40;
	final int SHOW_DELAY = 350;
	final int[][][] SHAPES = {
			{{0,0,0,0}, {1,1,1,1},{0,0,0,0}, {0,0,0,0},{4, 0x00f0f0}},  // I
			{{0,0,0,0}, {0,1,1,0},{0,1,1,0}, {0,0,0,0},{4, 0xf0f000}},  // O
			{{1,0,0,0}, {1,1,1,0},{0,0,0,0}, {0,0,0,0},{3, 0x0000f0}},  // J
			{{0,0,1,0}, {1,1,1,0},{0,0,0,0}, {0,0,0,0},{3, 0xf0a000}},  // L
			{{0,1,1,0}, {1,1,0,0},{0,0,0,0}, {0,0,0,0},{3, 0x00f000}},  // S
			{{1,1,1,0}, {0,1,0,0},{0,0,0,0}, {0,0,0,0},{3, 0x0000f0}},  // T
			{{1,1,0,0}, {0,1,1,0},{0,0,0,0}, {0,0,0,0},{3, 0xf00000}}   // Z
	};
	final int[] SCORES = {100, 300, 700, 1500};
	int gameScores = 0;
	int[][] mine = new int[FIELD_HEIGTH + 1][FIELD_WIDTH];
	JFrame frame;
	Canvas canvasPanel = new Canvas();
	Random random = new Random();
	Figure figure = new Figure();
	boolean gameOver = false;
	
	final int[][] GAME_OVER_MSG = {
			{0,1,1,0,0,0,1,1,0,0,0,1,0,1,0,0,0,1,1,0},
			{1,0,0,0,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,1},
			{1,0,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1},
			{1,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,0},
			{0,1,1,0,0,1,0,0,1,0,1,0,1,0,1,0,0,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,0,0,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0},
			{1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0},
			{1,0,0,1,0,1,0,1,0,0,1,1,1,1,0,1,1,1,0,0},
			{1,0,0,1,0,1,1,0,0,0,1,0,0,0,0,1,0,0,1,0},
			{0,1,1,0,0,1,0,0,0,0,0,1,1,0,0,1,0,0,1,0}};
	
	public static void main(String[] args) {
		new GameTetris().go();
	}
	
	private void go() {
		frame = new JFrame(TITLE_OF_PROGRAM);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FIELD_WIDTH*BLOCK_SIZE+ FIELD_DX,FIELD_HEIGTH*BLOCK_SIZE+FIELD_DY);
		frame.setLocation(START_LOCATION, START_LOCATION);
		frame.setResizable(false);
		
		frame.setVisible(true);
		
	}
}
