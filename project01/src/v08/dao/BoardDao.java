package v08.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import v08.Exception.DaoException;
import v08.domain.Board;

public class BoardDao {
  ArrayList<Board> list = new ArrayList<Board>();
  String filename = "./data/board.dat";
  public BoardDao() {
    try(
        FileReader in = new FileReader(filename);
        BufferedReader in2 = new BufferedReader(in);
        ){
    String line = null;
    
    while ((line = in2.readLine()) != null) {
      list.add(new Board(line));
    }
    }catch (Exception e) {
      throw new DaoException("게시물정보 로딩 실패!");
    }
  }
  public void save(){
    try(
        FileWriter out = new FileWriter("./data/Board.dat");
        BufferedWriter out2 = new BufferedWriter(out);
        PrintWriter out3 =new PrintWriter(out2);
        ){
      for (Board s : list) {
        out3.println(s);
      }
    }catch (Exception e) {
      throw new DaoException("게시물정보 저장 실패");
    }
  }
  public ArrayList<Board> selectList() {
    return list;
  }
  public void insert(Board board) {
    list.add(board);
  }

  public Board delete(int no) {
    return list.remove(no);
  }
}
