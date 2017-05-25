/**
 *
 */
package com.internousdev.info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.info.dto.UrlDTO;
import com.internousdev.util.DBConnector;

/**
 * Urlテーブルに関するDAOクラス
 * @author BABATAKUMA
 * @since 2017/4/27
 *
 */
public class UrlDAO  {

	private ArrayList<UrlDTO> list=new ArrayList<>();

	private DBConnector db=new DBConnector("infocom");
	private Connection con=db.getConnection();
	/**
	 * urlテーブルにurlを挿入するメソッド
	 * @param siteId サイトID
	 * @param itemId　商品ID
	 * @param url　url
	 * @return count 実行回数
	 */
	public int insert(int siteId,int itemId,String url,int pass){
		int count =0;

		String sql ="insert into url(site_id,item_id,pass,url)values(?,?,?,?)";
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, siteId);
			ps.setInt(2, itemId);
			ps.setInt(3, pass);
			ps.setString(4, url);

			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * urlテーブルにあるすべてのURL情報をリストに格納する　
	 * @return list 取得してきたURLが入っている
	 */
	public ArrayList<UrlDTO> select(){

		String sql="select * from url";
		try {
			PreparedStatement ps=con.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				UrlDTO dto=new UrlDTO();
				dto.setUrl(rs.getString("url"));
				dto.setUrlId(rs.getInt("url_id"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	/**
	 * urlを基にpassを持ってくるメソッド
	 * @param url　url
	 * @return pass pass
	 */
	public int passSelect(String url){
		int pass=0;


		String sql="select * from url where url=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,url);

			ResultSet rs=ps.executeQuery();

			rs.next();
			pass=rs.getInt("pass");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pass;
	}


	/**
	 * URLのすべての情報を取得するメソッド
	 * クローズするため別に作成
	 * @return list すべてのデータ
	 */
	public ArrayList<UrlDTO> allSelect(){

		String sql="select * from url";

		try {
			PreparedStatement ps=con.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				UrlDTO dto=new UrlDTO();
				dto.setItemId(rs.getInt("item_id"));
				dto.setPass(rs.getInt("pass"));
				dto.setSiteId(rs.getInt("site_id"));
				dto.setUrlId(rs.getInt("url_id"));
				dto.setUrl(rs.getString("url"));

				list.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		return list;
	}


	/**
	 * url情報を更新するメソッド
	 * @param url　URL
	 * @param pass　パス
	 * @param siteId　サイトID
	 * @param itemId　商品ID
	 * @param urlId　URLID
	 * @return　count 実行回数
	 * @throws SQLException　例外処理
	 */
	public int update(String url,int pass,int siteId,int itemId,int urlId) throws SQLException{
		int count=0;
		String sql="update url set site_id=?,item_id=?, url=?,pass=? where url_id=?";

		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, siteId);
		ps.setInt(2, itemId);
		ps.setString(3, url);
		ps.setInt(4, pass);
		ps.setInt(5, urlId);

		count=ps.executeUpdate();

		con.close();

		return count;
	}


	/**
	 * urlのサイトパスを変更するメソッド
	 * @param siteId　サイトID
	 * @param pass　パス
	 * @return count 実行回数
	 */
	public int urlUpdate(int siteId , int pass){
		int count=0;
		DBConnector db=new DBConnector("infocom");
		Connection con=db.getConnection();


		String sql="update url set pass=? where site_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pass);
			ps.setInt(2, siteId);

			count=ps.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}


		return count;
	}


	/**
	 * 商品IDとサイトIDからURLIDを取得する
	 * @param itemId 商品ID
	 * @param siteId サイトID
	 * @return count URLIDD
	 */
	public int urlSelect(int itemId,int siteId){
		int count=0;
		DBConnector db=new DBConnector("infocom");
		Connection con=db.getConnection();

		String sql="SELECT * FROM url WHERE item_id =? and site_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ps.setInt(2, siteId);
			ResultSet rs=ps.executeQuery();

			rs.next();
			count=rs.getInt("url_id");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

}
