package fwwb.classMoments.utils;

/**
 * Created by hongcj on 2017/5/6.
 */
public class ConstantValues {
    public static final int MAX_INT11 = 2147483647;

    public static final int ONE_DAY_TIMESTAMP = 86400;

    /**
     * 在评论表中回复的评论id暨reply_to字段为users表中id外键，
     * 为了可以发布新的暨没有reply_to的评论，将1号用户作为特殊用户，
     * 每次发新评论时候可以不带moment_id参数，或者参数值置为null，
     * 返回的所有关于评论的数据只要新评论或者是回复给1号用户的.
     * 其reply_user字段为一个初始化的userDTO对象,
     * 故其他地方也不要使用1号用户，不然可能会导致意想不到的后果.
     */
    public static final int REPLY_2_EMPTY = 1;
}
