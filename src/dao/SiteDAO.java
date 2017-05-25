/**
 *
 */
package com.internousdev.info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.info.dto.SiteDTO;
import com.internousdev.util.DBConnector;

/**
 * siteテーブルに関するDAOクラス
 * @author BABATAKUMA
 *@since 2017/4/27
 */
public class SiteDAO {




	/**
	 * サイト名を登録するメソッド
	 * @param siteName サイト名
	 * @return count 実行回数
	 */
	public int insert(String siteName,int pass){
		DBConnector db=new DBConnector("infocom");
		Connection con =db.getConnection();
		int count=0;
		String sql="insert into site(site_name,pass)values(?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);

			ps.setString(1, siteName);
			ps.setInt(2, pass);

			count=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return count;

	}


	/**
	 * サイト名を基にサイトIDを検索するメソッド
	 * @param siteName サイト名
	 * @return siteId サイトID
	 */
	public int siteSelect(String siteName){
		int siteId=0;
		DBConnector db=new DBConnector("infocom");
		Connection con =db.getConnection();
		String sql="select * from site where site_name=?";

		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, siteName);
			ResultSet rs = ps.executeQuery();
			rs.next();
			siteId=rs.getInt("site_id");

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

		return siteId;
	}


	/**
	 * サイト名からそのサイトのpassを取得する
	 * @param siteName　サイト名
	 * @return pass サイトパス
	 */
	public int sitePassSelect(String siteName){
		int pass=0;
		DBConnector db=new DBConnector("infocom");
		Connection con =db.getConnection();
		String sql="select * from site where site_name=?";

		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, siteName);
			ResultSet rs = ps.executeQuery();

			rs.next();
			pass=rs.getInt("pass");


		} catch (SQLException e) {
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return pass;
	}


	/**
	 * サイト情報をすべて検索するメソッド
	 * @return list サイト情報
	 */
	public ArrayList<SiteDTO> allSelect(){
		ArrayList<SiteDTO> list=new ArrayList<>();
		DBConnector db=new DBConnector("infocom");
		Connection con =db.getConnection();

		String sql="select * from site";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				SiteDTO dto=new SiteDTO();
				dto.setSiteId(rs.getInt("site_id"));
				dto.setPass(rs.getInt("pass"));
				dto.setSiteName(rs.getString("site_name"));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return  list;
	}



	/**
	 * サイト情報を更新するメソッド
	 * @param siteName　サイト名
	 * @param siteId　サイトID
	 * @param pass　パス
	 * @return　count 実行回数
	 */
	public int siteUpdate(String siteName,int siteId,int pass){
		int count=0;
		DBConnector db=new DBConnector("infocom");
		Connection con =db.getConnection();
		String sql=null;
		PreparedStatement ps=null;

		sql="update site set site_name=? , pass=? where site_id=?";

		try {
			 ps=con.prepareStatement(sql);
			ps.setString(1,siteName);
			ps.setInt(2,pass);
			ps.setInt(3, siteId);


			count=ps.executeUpdate();

		} catch (SQLException e) {
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
	 * サイト検索用メソッド
	 * @param name　入力されたやつ
	 * @return　list 検索結果
	 * @throws SQLException　例外処理
	 */
	public ArrayList<SiteDTO> siteNameSelect(String name) throws SQLException{
		ArrayList<SiteDTO> list=new ArrayList<>();
		PreparedStatement ps=null;
		DBConnector db=new DBConnector("infocom");
		Connection con =db.getConnection();
		if(name !=null){
		String sql="select * from site where site_name LIKE ?";
		ps = con.prepareStatement(sql);

		String select="%"+name+"%";
		ps.setString(1, select);
		}else{
			String sql="select * from site";
			ps = con.prepareStatement(sql);
		}


		ResultSet rs =ps.executeQuery();

		while(rs.next()){
			SiteDTO dto = new SiteDTO();
			dto.setSiteId(rs.getInt("site_id"));
			dto.setSiteName(rs.getString("site_name"));

			list.add(dto);
		}
		con.close();
		return list;
	}

}
