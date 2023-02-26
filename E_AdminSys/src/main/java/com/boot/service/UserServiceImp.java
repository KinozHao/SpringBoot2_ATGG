package com.boot.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.mapper.UserMapper;
import com.boot.pojo.User;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author kinoz
 * @Date 2023/2/26 18:23
 * @apiNote
 */
@Service
public class UserServiceImp extends ServiceImpl<UserMapper,User> implements UserService{
    @Override
    public boolean save(User entity) {
        return super.save(entity);
    }

    @Override
    public boolean saveBatch(Collection<User> entityList) {
        return super.saveBatch(entityList);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<User> entityList) {
        return super.saveOrUpdateBatch(entityList);
    }

    @Override
    public boolean removeById(User entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return super.removeByMap(columnMap);
    }

    @Override
    public boolean remove(Wrapper<User> queryWrapper) {
        return super.remove(queryWrapper);
    }

    @Override
    public boolean removeByIds(Collection<?> list, boolean useFill) {
        return super.removeByIds(list, useFill);
    }

    @Override
    public boolean removeBatchByIds(Collection<?> list) {
        return super.removeBatchByIds(list);
    }

    @Override
    public boolean removeBatchByIds(Collection<?> list, boolean useFill) {
        return super.removeBatchByIds(list, useFill);
    }

    @Override
    public boolean updateById(User entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean update(Wrapper<User> updateWrapper) {
        return super.update(updateWrapper);
    }

    @Override
    public boolean update(User entity, Wrapper<User> updateWrapper) {
        return super.update(entity, updateWrapper);
    }

    @Override
    public boolean updateBatchById(Collection<User> entityList) {
        return super.updateBatchById(entityList);
    }

    @Override
    public User getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public List<User> listByIds(Collection<? extends Serializable> idList) {
        return super.listByIds(idList);
    }

    @Override
    public List<User> listByMap(Map<String, Object> columnMap) {
        return super.listByMap(columnMap);
    }

    @Override
    public User getOne(Wrapper<User> queryWrapper) {
        return super.getOne(queryWrapper);
    }

    @Override
    public long count() {
        return super.count();
    }

    @Override
    public long count(Wrapper<User> queryWrapper) {
        return super.count(queryWrapper);
    }

    @Override
    public List<User> list(Wrapper<User> queryWrapper) {
        return super.list(queryWrapper);
    }

    @Override
    public List<User> list() {
        return super.list();
    }

    @Override
    public <E extends IPage<User>> E page(E page, Wrapper<User> queryWrapper) {
        return super.page(page, queryWrapper);
    }

    @Override
    public <E extends IPage<User>> E page(E page) {
        return super.page(page);
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<User> queryWrapper) {
        return super.listMaps(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listMaps() {
        return super.listMaps();
    }

    @Override
    public List<Object> listObjs() {
        return super.listObjs();
    }

    @Override
    public <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return super.listObjs(mapper);
    }

    @Override
    public List<Object> listObjs(Wrapper<User> queryWrapper) {
        return super.listObjs(queryWrapper);
    }

    @Override
    public <V> List<V> listObjs(Wrapper<User> queryWrapper, Function<? super Object, V> mapper) {
        return super.listObjs(queryWrapper, mapper);
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page, Wrapper<User> queryWrapper) {
        return super.pageMaps(page, queryWrapper);
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page) {
        return super.pageMaps(page);
    }

    @Override
    public QueryChainWrapper<User> query() {
        return super.query();
    }

    @Override
    public LambdaQueryChainWrapper<User> lambdaQuery() {
        return super.lambdaQuery();
    }

    @Override
    public LambdaQueryChainWrapper<User> lambdaQuery(User entity) {
        return super.lambdaQuery(entity);
    }

    @Override
    public KtQueryChainWrapper<User> ktQuery() {
        return super.ktQuery();
    }

    @Override
    public KtUpdateChainWrapper<User> ktUpdate() {
        return super.ktUpdate();
    }

    @Override
    public UpdateChainWrapper<User> update() {
        return super.update();
    }

    @Override
    public LambdaUpdateChainWrapper<User> lambdaUpdate() {
        return super.lambdaUpdate();
    }

    @Override
    public boolean saveOrUpdate(User entity, Wrapper<User> updateWrapper) {
        return super.saveOrUpdate(entity, updateWrapper);
    }
}
