/**
 *
 */
package com.internousdev.info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.internousdev.info.dto.InfoDTO;
import com.internousdev.util.DBConnector;

/**
 * infoテーブルに関するDAOクラス
 * @author BABATAKUMA
 * @since 2017/4/26
 *
 */
public class InfoDAO {


	private DBConnector db=new DBConnector("infocom");
	private Connection con =db.getConnection();

	private HashMap<Integer,ArrayList<InfoDTO>> allList =new HashMap<Integer,ArrayList<InfoDTO>>();

	private  ArrayList<InfoDTO> list =new ArrayList<>();
	/**
	 * 取得してきたサイト名とIDに対して値段を挿入するメソッド
	 * @param price 値段
	 * @param siteName サイト名
	 * @param updateCount 更新回数
	 * @param siteId サイトID
	 * @return count 更新回数
	 */
	public int insert(int price,int urlId){
		int count=0;

		String sql ="insert into info(url_id,price)values(?,?)";


		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, urlId);
			ps.setInt(2, price);

			count=ps.executeUpdate();

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

		return count;

	}

/**
 * urlidの最大値を取得するメソッド　使用しない
 * @return max max(url_id)
 */
	public int maxUrl(){
		int max=0;
		String sql="select max(url_id) from info";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			max=rs.getInt("max(url_id)");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return max;

	}


	/**
	 * infoにはいっている値段を全て降順でとってくる　使用しない
	 * @param max urlの最大値
	 * @return list 最大値の入ったリスト
	 */
	public HashMap<Integer,ArrayList<InfoDTO>> priceGet(int max)
{

		String sql="select * from info where url_id=? ORDER BY registration_date DESC";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			for(int i=1;i<=max;i++){
				list =new ArrayList<InfoDTO>();
				ps.setInt(1,i);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					InfoDTO dto=new InfoDTO();
					dto.setPrice(rs.getInt("price"));
					list.add(dto);
				}
				allList.put(i,list);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return allList;
	}






	public ArrayList<InfoDTO> priceSelect(int urlId)
	{
		String sql="select * from info where url_id=? ORDER BY registration_date DESC";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, urlId);

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				InfoDTO dto=new InfoDTO();
				dto.setPrice(rs.getInt("price"));
				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return list;

	}


}
