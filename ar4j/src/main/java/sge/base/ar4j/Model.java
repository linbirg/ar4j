package sge.base.ar4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import sge.base.dao.BaseSpringDaoImpl;
import sge.base.utils.Pair;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class Model<M extends Model> {

	private BaseSpringDaoImpl<M> dao;
	private Class clazz;

	private Class returnedClass() {
		Class clazz = this.getClass();
		ParameterizedType parameterizedType = null;
		while (clazz != Object.class) {
			try {
				parameterizedType = (ParameterizedType) clazz
						.getGenericSuperclass();
			} catch (Throwable e) {
				clazz = clazz.getSuperclass();
				continue;
			}
			break;
		}
		Type type = parameterizedType.getActualTypeArguments()[0];
		return (Class) type;
	}

	public Model() {
		clazz = returnedClass();
		dao = new BaseSpringDaoImpl<M>(clazz);
	}

	public void save() {
		dao.insert((M) this);
	}

	public void delete() {
		dao.delete((M) this);
	}

	public static <M extends Model> List<M> find_where(Class<M> clazz,
			String where, Object... args) {
		BaseSpringDaoImpl<M> daoImpl = new BaseSpringDaoImpl<M>(clazz);
		return daoImpl.select(where, args);
	}

	public static <M extends Model> Pair<List<M>, Long> paginate(
			Class<M> clazz, String where, int pageNum, int PageSize,
			Object... args) {
		BaseSpringDaoImpl<M> daoImpl = new BaseSpringDaoImpl<M>(clazz);
		return daoImpl.selectPage(where, pageNum, PageSize, args);
	}
}
