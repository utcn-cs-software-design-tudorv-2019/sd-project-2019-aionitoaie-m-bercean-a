package Model.Repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import Model.Entities.Person;
import Model.Entities.Plot;
import Model.Entities.PlotDetail;

public class PlotDetailCRUD implements MasterInterface<PlotDetail, Integer>{
	
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    Session session;

	public void create(PlotDetail obiect) {
		System.out.println("Creating new plot detail record...");
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(obiect);
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<PlotDetail> selectAll(){
		session = sessionFactory.openSession();
		
		Query q = session.createQuery("SELECT * FROM PlotDetail");
		List<PlotDetail> a = q.list();
		return a;
	}
	
	public PlotDetail read(Integer idObiect) {
		PlotDetail p;
		
		System.out.println("Reading plot detail record...");
		session = sessionFactory.openSession();

		p = (PlotDetail)session.get(PlotDetail.class, idObiect);
		
		session.close();
		
		return p;
	}

	public void update(PlotDetail obiect) {
		System.out.println("Updating plot detail...");
		session = sessionFactory.openSession();
		
		PlotDetail p = (PlotDetail) session.get(PlotDetail.class, obiect.getPlotDetailId());
		
		//p.setStartD(obiect.getStartD());
		//p.setDuration(obiect.getDuration());
		//p.setDate(obiect.getDate());
		//p.setPrice(obiect.getPrice());
		//p.setCar(obiect.getCar());
		//p.setOccupied(obiect.getOccupiedState());
		
		p.setDate(obiect.getDate());
		p.setEndHour(obiect.getEndHour());
		p.setOccupied(obiect.isOccupied());
		p.setStartHour(obiect.getStartHour());
		p.setPlot(obiect.getPlot());
		
		session.beginTransaction();
		session.saveOrUpdate(p);
		session.getTransaction().commit();
		
		session.close();
		
	}

	public void delete(Integer idObiect) {
		System.out.println("Deleting plot detail record...");
		session = sessionFactory.openSession();
		
		PlotDetail p = (PlotDetail) session.get(PlotDetail.class, idObiect);
		
		
		session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
		
		session.close();
		
	}

}
