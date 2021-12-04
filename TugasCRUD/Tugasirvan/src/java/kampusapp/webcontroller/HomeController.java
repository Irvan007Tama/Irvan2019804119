/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampusapp.webcontroller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kampusapp.dao.KampusDAO;
import kampusapp.dao.KampusDAOProses;
import kampusapp.model.DatabaseConfig;
import kampusapp.model.Mahasiswa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author This-PC
 */
@Controller
public class HomeController {
    KampusDAO mhsDao=null;
    public HomeController (){
        mhsDao=new KampusDAOProses();
    }
    public ModelAndView listMahasiswa(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, IOException {
        List<Mahasiswa> theList = mhsDao.get();
        ModelAndView modelandview = new ModelAndView();
        modelandview.addObject("listMahasiswa", theList);
        return modelandview;
    }
    @RequestMapping(value="/home")
    public ModelAndView home(HttpServletRequest req,HttpServletResponse res) 
            throws ServletException, IOException, SQLException {
        return listMahasiswa(req,res);
        }
    }
