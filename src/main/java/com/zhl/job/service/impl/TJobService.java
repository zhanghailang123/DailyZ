package com.zhl.job.service.impl;

import com.zhl.job.model.entity.job.TJob;
import com.zhl.job.dao.job.TJobMapper;
import com.zhl.job.service.ITJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhanghailang
 * @since 2023-05-24
 */
@Service
public class TJobService extends ServiceImpl<TJobMapper, TJob> implements ITJobService {

}
