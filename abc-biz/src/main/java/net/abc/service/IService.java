package net.abc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 * @param <T>
 */
@Service
public interface IService<T> {

	public enum Status {
		START(1), STOP(0);

		private int value = 0;

		private Status(int value) {
			this.value = value;
		}

		public int value() {
			return this.value;
		}
	}

	T selectByKey(Object key);

	T getById(Object key);

	int save(T entity);

	int delete(Object key);

	int updateAll(T entity);

	int updateNotNull(T entity);

	List<T> selectByExample(Object example);

	@Transactional
	int deleteByKeys(String keys);
}
