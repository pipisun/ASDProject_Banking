package cs525.mum.factories;

public interface IFactory<T,R> {
	public R create(T dto);
}
