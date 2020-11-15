package project_ifrill.service.impl;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_ifrill.dto.Worker;
import project_ifrill.mapper.WorkerMapper;
import project_ifrill.service.WorkerService;

@Service
public class WorkerServiceImpl implements WorkerService {
	protected static final Log log = LogFactory.getLog(WorkerServiceImpl.class);
	
	@Autowired
	private WorkerMapper mapper;
	
	@Override
	public int workerCheck(Worker worker) {
		log.debug("service - workerCheck() worker >> " + worker);
		return mapper.workerCheck(worker);
	}

}
