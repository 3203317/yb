package net.abc.model;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public final class QueryModel {

	private Integer offset;
	private Integer pageSize;

	public Integer getOffset() {
		if (null == offset)
			return 0;

		if (0 > offset)
			return 0;

		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getPageSize() {
		if (null == pageSize)
			return Integer.MAX_VALUE;

		if (1 > pageSize)
			return Integer.MAX_VALUE;

		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
