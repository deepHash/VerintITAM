package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				View view = new View();
				Model model = new Model();
				view.setVisible(true);
				Start(view,model);
			}
		});
		
	}
	public static void Start(View view, Model model) {
		
		class btnSubmitListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					model.setAsset(view.getAsset());
					view.showChange(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}	
		}
		
		class btnInfoListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					model.getAssetInfo();
					view.showChange(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		}
		
		//action listeners bind for view
		view.submitAsset(new btnSubmitListener());
		view.assetInfo(new btnInfoListener());
	}
	


}
