package com.ccsu.crawler;

import com.ccsu.crawler.model.Seed;
import com.ccsu.crawler.util.DaoOperation;
import org.slf4j.LoggerFactory;

public class MainApplication {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MainApplication.class);

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String args[]) {
        while (true) {
            Seed seed = DaoOperation.getSeed();
            if (seed == null) {
                try {
                    logger.info("种子为空,请添加种子后重试,5分钟后继续执行代码");
                    Thread.sleep(1000 * 60 * 5);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    logger.info(e.getMessage());
                }
            }else {
                DaoOperation.addRepository(seed.getSeedlogin());
            }
            logger.info("--------------------Line--------------------");
        }
    }

}
