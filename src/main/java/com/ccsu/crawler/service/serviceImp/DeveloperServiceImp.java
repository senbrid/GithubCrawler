//package com.ccsu.crawler.service.serviceImp;
//
//import com.graduation.dao.DeveloperMapper;
//import com.graduation.model.Developer;
//import com.graduation.model.DeveloperExample;
//import com.graduation.service.DeveloperService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class DeveloperServiceImp implements DeveloperService {
//
//    @Autowired
//    private DeveloperMapper developerMapper;
//    /**
//     * 添加开发者数据
//     *
//     * @param developerList
//     * @author Joke
//     * Date 2018年3月21日15:36:35
//     */
//    public int addDeveloperByListPO(List<Developer> developerList) {
//
//        return developerMapper.insertBatch(developerList);
//    }
//
//    /**
//     * 批量更新数据
//     *
//     * @param developerList
//     * @author Joke
//     * Date 2018年3月22日16:06:39
//     */
//    @Override
//    public int updateDeveloperByListPO(List<Developer> developerList) {
//        return developerMapper.updateBatch(developerList);
//    }
//
//    /**
//     * 按主键更新数据
//     *
//     * @param developer
//     * @author Joke
//     * Date 2018年4月9日09:28:07
//     */
//    @Override
//    public int updateDeveloperById(Developer developer) {
//        return developerMapper.updateByPrimaryKey(developer);
//    }
//
//    /**
//     * 按条件查询
//     *
//     * @param example
//     * @author Joke
//     * Date 2018年4月3日12:00:37
//     */
//    @Override
//    public List<Developer> getDeveloperByExample(DeveloperExample example) {
//
//        return developerMapper.selectByExample(example);
//    }
//
//    /**
//     * 根据开发者ID查询开发者
//     *
//     * @param id
//     * @author Joke
//     * Date 2018年4月3日12:00:37
//     */
//    @Override
//    public Developer getDeveloperById(Long id) {
//        return developerMapper.selectByPrimaryKey(id);
//    }
//}
