package com.asa.base.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author andrew_asa
 * @date 2021/11/13.
 */
public class RandomUtils {

    /**
     * <p>
     * Returns a random boolean value
     * </p>
     *
     * @return the random boolean
     * @since 3.5
     */
    public static boolean nextBoolean() {
        return random().nextBoolean();
    }

    /**
     * <p>
     * Creates an array of random bytes.
     * </p>
     *
     * @param count
     *            the size of the returned array
     * @return the random byte array
     * @throws IllegalArgumentException if {@code count} is negative
     */
    public static byte[] nextBytes(final int count) {
        Validate.isTrue(count >= 0, "Count cannot be negative.");

        final byte[] result = new byte[count];
        random().nextBytes(result);
        return result;
    }

    /**
     * <p> Returns a random double within 0 - Double.MAX_VALUE </p>
     *
     * @return the random double
     * @see #nextDouble(double, double)
     * @since 3.5
     */
    public static double nextDouble() {
        return nextDouble(0, Double.MAX_VALUE);
    }

    /**
     * <p>
     * Returns a random double within the specified range.
     * </p>
     *
     * @param startInclusive
     *            the smallest value that can be returned, must be non-negative
     * @param endExclusive
     *            the upper bound (not included)
     * @throws IllegalArgumentException
     *             if {@code startInclusive > endExclusive} or if
     *             {@code startInclusive} is negative
     * @return the random double
     */
    public static double nextDouble(final double startInclusive, final double endExclusive) {
        Validate.isTrue(endExclusive >= startInclusive,
                        "Start value must be smaller or equal to end value.");
        Validate.isTrue(startInclusive >= 0, "Both range values must be non-negative.");

        if (startInclusive == endExclusive) {
            return startInclusive;
        }

        return startInclusive + ((endExclusive - startInclusive) * random().nextDouble());
    }

    /**
     * <p> Returns a random float within 0 - Float.MAX_VALUE </p>
     *
     * @return the random float
     * @see #nextFloat(float, float)
     * @since 3.5
     */
    public static float nextFloat() {
        return nextFloat(0, Float.MAX_VALUE);
    }

    /**
     * <p>
     * Returns a random float within the specified range.
     * </p>
     *
     * @param startInclusive
     *            the smallest value that can be returned, must be non-negative
     * @param endExclusive
     *            the upper bound (not included)
     * @throws IllegalArgumentException
     *             if {@code startInclusive > endExclusive} or if
     *             {@code startInclusive} is negative
     * @return the random float
     */
    public static float nextFloat(final float startInclusive, final float endExclusive) {
        Validate.isTrue(endExclusive >= startInclusive,
                        "Start value must be smaller or equal to end value.");
        Validate.isTrue(startInclusive >= 0, "Both range values must be non-negative.");

        if (startInclusive == endExclusive) {
            return startInclusive;
        }

        return startInclusive + ((endExclusive - startInclusive) * random().nextFloat());
    }

    /**
     * <p> Returns a random int within 0 - Integer.MAX_VALUE </p>
     *
     * @return the random integer
     * @see #nextInt(int, int)
     * @since 3.5
     */
    public static int nextInt() {
        return nextInt(0, Integer.MAX_VALUE);
    }

    /**
     * <p>
     * Returns a random integer within the specified range.
     * </p>
     *
     * @param startInclusive
     *            the smallest value that can be returned, must be non-negative
     * @param endExclusive
     *            the upper bound (not included)
     * @throws IllegalArgumentException
     *             if {@code startInclusive > endExclusive} or if
     *             {@code startInclusive} is negative
     * @return the random integer
     */
    public static int nextInt(final int startInclusive, final int endExclusive) {
        Validate.isTrue(endExclusive >= startInclusive,
                        "Start value must be smaller or equal to end value.");
        Validate.isTrue(startInclusive >= 0, "Both range values must be non-negative.");

        if (startInclusive == endExclusive) {
            return startInclusive;
        }

        return startInclusive + random().nextInt(endExclusive - startInclusive);
    }

    /**
     * <p> Returns a random long within 0 - Long.MAX_VALUE </p>
     *
     * @return the random long
     * @see #nextLong(long, long)
     * @since 3.5
     */
    public static long nextLong() {
        return nextLong(Long.MAX_VALUE);
    }

    /**
     * Generates a {@code long} value between 0 (inclusive) and the specified
     * value (exclusive).
     *
     * @param n Bound on the random number to be returned.  Must be positive.
     * @return a random {@code long} value between 0 (inclusive) and {@code n}
     * (exclusive).
     */
    private static long nextLong(final long n) {
        // Extracted from o.a.c.rng.core.BaseProvider.nextLong(long)
        long bits;
        long val;
        do {
            bits = random().nextLong() >>> 1;
            val  = bits % n;
        } while (bits - val + (n - 1) < 0);

        return val;
    }

    /**
     * <p>
     * Returns a random long within the specified range.
     * </p>
     *
     * @param startInclusive
     *            the smallest value that can be returned, must be non-negative
     * @param endExclusive
     *            the upper bound (not included)
     * @throws IllegalArgumentException
     *             if {@code startInclusive > endExclusive} or if
     *             {@code startInclusive} is negative
     * @return the random long
     */
    public static long nextLong(final long startInclusive, final long endExclusive) {
        Validate.isTrue(endExclusive >= startInclusive,
                        "Start value must be smaller or equal to end value.");
        Validate.isTrue(startInclusive >= 0, "Both range values must be non-negative.");

        if (startInclusive == endExclusive) {
            return startInclusive;
        }

        return startInclusive + nextLong(endExclusive - startInclusive);
    }

    private static ThreadLocalRandom random() {
        return ThreadLocalRandom.current();
    }

    /**
     * <p>
     * {@code RandomUtils} instances should NOT be constructed in standard
     * programming. Instead, the class should be used as
     * {@code RandomUtils.nextBytes(5);}.
     * </p>
     *
     * <p>
     * This constructor is public to permit tools that require a JavaBean
     * instance to operate.
     * </p>
     */
    public RandomUtils() {
    }
}
