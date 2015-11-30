package v11.server.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import v11.exception.DaoException;
import v11.server.annotation.Component;
import v11.server.domain.Board;

@Component
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
    this.save();
  }

  public Board delete(int no) {
    Board obj = list.remove(no);
    this.save();
    return obj;
  }
}
