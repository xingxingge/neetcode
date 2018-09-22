package com.topsec.tsm.datastructure;

import com.topsec.tsm.datastructure.stack.Stack;
import com.topsec.tsm.datastructure.stack.StackSLinked;

public class MazeExit {

	/**
	 * 找到从起点到终点的路径
	 * **/

	public void mazeExit(char[][] maze, int sx, int sy, int ex, int ey) {
		Cell[][] cells = createMaze(maze); // 
		printMaze(cells); // 
		Stack<Cell> s = new StackSLinked<Cell>(); // 
		Cell startCell = cells[sx][sy]; // 
		Cell endCell = cells[ex][ey]; //
		s.push(startCell); // 
		startCell.visited = true; // 
		while (!s.isEmpty()) {
			Cell current = (Cell) s.peek();
			if (current == endCell) { // ·
				while (!s.isEmpty()) {
					Cell cell = (Cell) s.pop();// 
					cell.c = '*';
					//堆栈中与cell相邻的单元才是路径的组成部分，除此之外，
					//堆栈中还有记录下来但是未继续向下探索的单元，
					//这些单元直接出栈
					while (!s.isEmpty()
							&& !isAdjoinCell((Cell) s.peek(), cell))
						s.pop();
				}
				System.out.println("找到从起点到终点的路径。");
				printMaze(cells);
				return;
			} else { // //如果当前位置不是终点
				int x = current.x;
				int y = current.y;
				int count = 0;
				if (isValidWayCell(cells[x + 1][y])) { // 向下
					s.push(cells[x + 1][y]);
					cells[x + 1][y].visited = true;
					count++;
				}
				if (isValidWayCell(cells[x][y + 1])) { // 向右
					s.push(cells[x][y + 1]);
					cells[x][y + 1].visited = true;
					count++;
				}
				if (isValidWayCell(cells[x - 1][y])) { // 向上
					s.push(cells[x - 1][y]);
					cells[x - 1][y].visited = true;
					count++;
				}
				if (isValidWayCell(cells[x][y - 1])) { // 向左
					s.push(cells[x][y - 1]);
					cells[x][y - 1].visited = true;
					count++;
				}
				if (count == 0)
					s.pop();//如果是死点，出栈
			}
		}
		System.out.println("没有从起点到终点的路径。");
	}

	private void printMaze(Cell[][] cells) {
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[x].length; y++)
				System.out.print(cells[x][y].c);
			System.out.println();
		}
	}

	private boolean isAdjoinCell(Cell cell1, Cell cell2) {
		if (cell1.x == cell2.x && Math.abs(cell1.y - cell2.y) < 2)
			return true;
		if (cell1.y == cell2.y && Math.abs(cell1.x - cell2.x) < 2)
			return true;
		return false;
	}

	private boolean isValidWayCell(Cell cell) {
		return cell.c == '0' && !cell.visited;
	}

	private Cell[][] createMaze(char[][] maze) {
		Cell[][] cells = new Cell[maze.length][];
		for (int x = 0; x < maze.length; x++) {
			char[] row = maze[x];
			cells[x] = new Cell[row.length];
			for (int y = 0; y < row.length; y++)
				cells[x][y] = new Cell(x, y, maze[x][y], false);
		}
		return cells;
	}
}
