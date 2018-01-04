package kr.co.kidultAuction.view;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.kidultAuction.controller.KidultServer;

public class RunAction {

	public static void main(String[] args) throws IOException {
		new AuctionMainFrm();
		new KidultServer();
		
	}//main

}//class
