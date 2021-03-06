package com.github.liuweijw.business.admin.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.github.liuweijw.business.admin.cache.AdminCacheKey;
import com.github.liuweijw.business.admin.domain.Module;
import com.github.liuweijw.business.admin.domain.QModule;
import com.github.liuweijw.business.admin.service.ModuleService;
import com.github.liuweijw.business.commons.web.jpa.JPAFactoryImpl;

@Component
public class ModuleServiceImpl extends JPAFactoryImpl implements ModuleService {

	@Override
	@Cacheable(value = AdminCacheKey.MODULE_INFO_LIST)
	public List<Module> getAllList() {
		QModule qModule = QModule.module;

		return this.queryFactory.selectFrom(qModule).fetch();
	}

}
