package servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.MySQLController;

/**
 * Servlet implementation class UploadImage
 * @category Servlet
 * @author Aaron Goy Ding Xian
*/

public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String dsn = "careattack";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadImage() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(processFileForm(request) != null)
		{
			response.getWriter().println("<script>alert('Sucess at file upload!')</script>");
		}
		else
		{
			response.getWriter().println("<script>alert('Something went wrong =( ')</script>");
		}
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public ArrayList<String> processFileForm(HttpServletRequest request)
	{
		ArrayList<String> arrList = new ArrayList<String>();
		System.out.println("In Method processFileForm!");
		boolean success = false;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			System.out.println("Request :  " + request);
			System.out.println("Request End! ");
			List<?> items;
			try {
				items = upload.parseRequest(request);
				Iterator<?> iterator = items.iterator();
				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();

					if (!item.isFormField()) {
						String fileName = item.getName();
						System.out.println("File Name of uploaded file : "
								+ fileName);
						uploadFile(item, fileName);
						if(success)
						{
							System.out.println("File creation success!");
						}
					}
				}
			} catch (FileUploadException e) {
				System.out.println("================================");
				System.out.println("Start of FileUploadException details");
				e.printStackTrace();
				System.out.println("End of FileUploadException");
				System.out.println("===================================");
			}catch(SQLException sqlErr)
			{
				System.out.println("Theres an error with the SQL Query");
				sqlErr.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
		return arrList;
	}

	/**
	 * Processes uploaded file and writes file out to server and filename to Database
	 * 
	 * This method uploadFile processes the FileItem parsed from
	 * the request and the file name and uses both to output the file out
	 * to the server through the file path specified and returns true if
	 * success and false for failure.
	 * This method will call upon uploadFileDataToDB
	 * @param item (FileItem)
	 * @param fileName (String)
	 * @return success 
	 * @throws FileUploadException
	 * @throws IOException
	 * @throws SQLException
	 */
	private boolean uploadFile(FileItem item, String fileName) throws FileUploadException,IOException,SQLException {
		boolean success = false;
			// String root = getServletContext().getRealPath("/");
			// Note that for File path, please replace the path name
			// in the constructor with the path of your directory
			// Note that it is temporary until a soln is found.
		try{
			File path = new File(
					"C:\\Users\\Evangeline\\Desktop\\Project\\Care-Attack_1_10\\WebContent\\images");
			File uploadedFile = new File(path + "/" + fileName);
			System.out.println("path of uploaded file : "
					+ uploadedFile.getAbsolutePath());
			if (path.exists()) {
				item.write(uploadedFile);
			} else {
				path.mkdirs();
				item.write(uploadedFile);
			}
			uploadFileDataToDB(fileName);
			success = true; 
			}catch(Exception e)
			{
				System.out.println("Something went wrong :(");
				e.printStackTrace();
			}
		return success;
	}
	
	/**
	 * Takes the file name and inserts a record into the database table
	 * 
	 * @param fileName (String)
	 * @return success (boolean)
	 * @throws SQLException
	 * @author Aaron Goy Ding Xian
	 */
	private boolean uploadFileDataToDB(String fileName) throws SQLException {
		MySQLController mysql = new MySQLController();
		mysql.setUp(dsn);
		String dbQuery = "INSERT INTO image(imagePath)";
		dbQuery += "VALUES('" + fileName + "')";
		boolean success = false;
		int result = mysql.updateRequest(dbQuery);
		if(result == 1)
		{
			success = true;
		}
		return success;
	}

	// FIXME
	public void getCurrentProgress() {
		// Create a progress listener
		@SuppressWarnings("unused")
		ProgressListener progressListener = new ProgressListener() {
			public void update(long pBytesRead, long pContentLength, int pItems) {
				System.out.println("We are currently reading item " + pItems);
				if (pContentLength == -1) {
					System.out.println("So far, " + pBytesRead
							+ " bytes have been read.");
				} else {
					System.out.println("So far, " + pBytesRead + " of "
							+ pContentLength + " bytes have been read.");
				}
			}
		};
	}

	// Sample of how the upload image should be in html/jsp
	// <form name="uploadForm" id="uploadForm" method="POST"
	// action="UploadImage" enctype="multipart/form-data">
	// <input type="file" value="sy" name="sy"></input> <input
	// type="submit" />
	// </form>
}
