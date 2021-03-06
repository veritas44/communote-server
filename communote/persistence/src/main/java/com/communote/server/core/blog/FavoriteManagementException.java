package com.communote.server.core.blog;


/**
 * The default exception thrown for unexpected errors occurring within
 * {@link com.communote.server.core.blog.FavoriteManagement}.
 *
 * @author Communote GmbH - <a href="http://www.communote.com/">http://www.communote.com/</a>
 */
public class FavoriteManagementException extends RuntimeException {
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = -8984648421251603448L;

    /**
     * Constructs a new instance of <code>FavoriteManagementException</code>.
     *
     * @param message
     *            the throwable message.
     */
    public FavoriteManagementException(String message) {
        super(message);
    }

    /**
     * Constructs a new instance of <code>FavoriteManagementException</code>.
     *
     * @param message
     *            the throwable message.
     * @param throwable
     *            the parent of this Throwable.
     */
    public FavoriteManagementException(String message, Throwable throwable) {
        super(message, throwable);
    }
}