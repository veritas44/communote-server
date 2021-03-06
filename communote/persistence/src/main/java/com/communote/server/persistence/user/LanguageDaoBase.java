package com.communote.server.persistence.user;

/**
 * <p>
 * Base Spring DAO Class: is able to create, update, remove, load, and find objects of type
 * <code>com.communote.server.persistence.user.Language</code>.
 * </p>
 * 
 * @see com.communote.server.model.user.Language
 * @author Communote GmbH - <a href="http://www.communote.com/">http://www.communote.com/</a>
 */
public abstract class LanguageDaoBase extends
        org.springframework.orm.hibernate3.support.HibernateDaoSupport implements
        com.communote.server.persistence.user.LanguageDao {

    /**
     * @see com.communote.server.persistence.user.LanguageDao#create(com.communote.server.model.user.Language)
     */
    public com.communote.server.model.user.Language create(
            com.communote.server.model.user.Language language) {
        return (com.communote.server.model.user.Language) this.create(TRANSFORM_NONE, language);
    }

    /**
     * @see com.communote.server.persistence.user.LanguageDao#create(int transform,
     *      com.communote.server.persistence.user.Language)
     */
    public Object create(final int transform,
            final com.communote.server.model.user.Language language) {
        if (language == null) {
            throw new IllegalArgumentException("Language.create - 'language' can not be null");
        }
        this.getHibernateTemplate().save(language);
        return this.transformEntity(transform, language);
    }

    /**
     * @see com.communote.server.persistence.user.LanguageDao#create(int,
     *      java.util.Collection<com.communote.server.persistence.user.Language>)
     */
    public java.util.Collection<com.communote.server.model.user.Language> create(
            final int transform,
            final java.util.Collection<com.communote.server.model.user.Language> entities) {
        if (entities == null) {
            throw new IllegalArgumentException("Language.create - 'entities' can not be null");
        }
        this.getHibernateTemplate()
                .executeWithNativeSession(
                        new org.springframework.orm.hibernate3.HibernateCallback<com.communote.server.model.user.Language>() {
                            public com.communote.server.model.user.Language doInHibernate(
                                    org.hibernate.Session session)
                                    throws org.hibernate.HibernateException {
                                for (java.util.Iterator<com.communote.server.model.user.Language> entityIterator = entities
                                        .iterator(); entityIterator.hasNext();) {
                                    create(transform, entityIterator.next());
                                }
                                return null;
                            }
                        });
        return entities;
    }

    /**
     * @see 
     *      com.communote.server.persistence.user.LanguageDao#create(java.util.Collection<de.communardo
     *      .kenmei.core.api.bo.user.Language>)
     */
    @SuppressWarnings({ "unchecked" })
    public java.util.Collection<com.communote.server.model.user.Language> create(
            final java.util.Collection<com.communote.server.model.user.Language> entities) {
        return (java.util.Collection<com.communote.server.model.user.Language>) create(
                TRANSFORM_NONE, entities);
    }

    /**
     * {@inheritDoc}
     */
    public void evict(com.communote.server.model.user.Language entity) {
        this.getHibernateTemplate().evict(entity);
    }

    /**
     * @see com.communote.server.persistence.user.LanguageDao#findByLanguageCode(String)
     */
    public com.communote.server.model.user.Language findByLanguageCode(final String languageCode) {
        if (languageCode == null) {
            throw new IllegalArgumentException(
                    "com.communote.server.persistence.user.LanguageDao.findByLanguageCode(String languageCode) - 'languageCode' can not be null");
        }
        try {
            return this.handleFindByLanguageCode(languageCode);
        } catch (RuntimeException rt) {
            throw new RuntimeException(
                    "Error performing 'com.communote.server.persistence.user.LanguageDao.findByLanguageCode(String languageCode)' --> "
                            + rt, rt);
        }
    }

    /**
     * Performs the core logic for {@link #findByLanguageCode(String)}
     */
    protected abstract com.communote.server.model.user.Language handleFindByLanguageCode(
            String languageCode);

    /**
     * @see com.communote.server.persistence.user.LanguageDao#load(int, Long)
     */
    public Object load(final int transform, final Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Language.load - 'id' can not be null");
        }
        final Object entity = this.getHibernateTemplate().get(
                com.communote.server.model.user.LanguageImpl.class, id);
        return transformEntity(transform, (com.communote.server.model.user.Language) entity);
    }

    /**
     * @see com.communote.server.persistence.user.LanguageDao#load(Long)
     */
    public com.communote.server.model.user.Language load(Long id) {
        return (com.communote.server.model.user.Language) this.load(TRANSFORM_NONE, id);
    }

    /**
     * @see com.communote.server.persistence.user.LanguageDao#loadAll()
     */
    @SuppressWarnings({ "unchecked" })
    public java.util.Collection<com.communote.server.model.user.Language> loadAll() {
        return (java.util.Collection<com.communote.server.model.user.Language>) this
                .loadAll(TRANSFORM_NONE);
    }

    /**
     * @see com.communote.server.persistence.user.LanguageDao#loadAll(int)
     */
    public java.util.Collection<?> loadAll(final int transform) {
        final java.util.Collection<?> results = this.getHibernateTemplate().loadAll(
                com.communote.server.model.user.LanguageImpl.class);
        this.transformEntities(transform, results);
        return results;
    }

    /**
     * @see com.communote.server.persistence.user.LanguageDao#remove(com.communote.server.model.user.Language)
     */
    public void remove(com.communote.server.model.user.Language language) {
        if (language == null) {
            throw new IllegalArgumentException("Language.remove - 'language' can not be null");
        }
        this.getHibernateTemplate().delete(language);
    }

    /**
     * @see 
     *      com.communote.server.persistence.user.LanguageDao#remove(java.util.Collection<de.communardo
     *      .kenmei.core.api.bo.user.Language>)
     */
    public void remove(java.util.Collection<com.communote.server.model.user.Language> entities) {
        if (entities == null) {
            throw new IllegalArgumentException("Language.remove - 'entities' can not be null");
        }
        this.getHibernateTemplate().deleteAll(entities);
    }

    /**
     * @see com.communote.server.persistence.user.LanguageDao#remove(Long)
     */
    public void remove(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Language.remove - 'id' can not be null");
        }
        com.communote.server.model.user.Language entity = this.load(id);
        if (entity != null) {
            this.remove(entity);
        }
    }

    /**
     * Transforms a collection of entities using the
     * {@link #transformEntity(int,com.communote.server.model.user.Language)} method. This method
     * does not instantiate a new collection.
     * <p/>
     * This method is to be used internally only.
     * 
     * @param transform
     *            one of the constants declared in
     *            <code>com.communote.server.persistence.user.LanguageDao</code>
     * @param entities
     *            the collection of entities to transform
     * @see #transformEntity(int,com.communote.server.model.user.Language)
     */
    protected void transformEntities(final int transform, final java.util.Collection<?> entities) {
        switch (transform) {
        case TRANSFORM_NONE: // fall-through
        default:
            // do nothing;
        }
    }

    /**
     * Allows transformation of entities into value objects (or something else for that matter),
     * when the <code>transform</code> flag is set to one of the constants defined in
     * <code>com.communote.server.persistence.user.LanguageDao</code>, please note that the
     * {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself will be
     * returned.
     * 
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     * 
     * @param transform
     *            one of the constants declared in
     *            {@link com.communote.server.persistence.user.LanguageDao}
     * @param entity
     *            an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,java.util.Collection)
     */
    protected Object transformEntity(final int transform,
            final com.communote.server.model.user.Language entity) {
        Object target = null;
        if (entity != null) {
            switch (transform) {
            case TRANSFORM_NONE: // fall-through
            default:
                target = entity;
            }
        }
        return target;
    }

    /**
     * @see com.communote.server.persistence.user.LanguageDao#update(com.communote.server.model.user.Language)
     */
    public void update(com.communote.server.model.user.Language language) {
        if (language == null) {
            throw new IllegalArgumentException("Language.update - 'language' can not be null");
        }
        this.getHibernateTemplate().update(language);
    }

    /**
     * @see 
     *      com.communote.server.persistence.user.LanguageDao#update(java.util.Collection<de.communardo
     *      .kenmei.core.api.bo.user.Language>)
     */
    public void update(final java.util.Collection<com.communote.server.model.user.Language> entities) {
        if (entities == null) {
            throw new IllegalArgumentException("Language.update - 'entities' can not be null");
        }
        this.getHibernateTemplate()
                .executeWithNativeSession(
                        new org.springframework.orm.hibernate3.HibernateCallback<com.communote.server.model.user.Language>() {
                            public com.communote.server.model.user.Language doInHibernate(
                                    org.hibernate.Session session)
                                    throws org.hibernate.HibernateException {
                                for (java.util.Iterator<com.communote.server.model.user.Language> entityIterator = entities
                                        .iterator(); entityIterator.hasNext();) {
                                    update(entityIterator.next());
                                }
                                return null;
                            }
                        });
    }

}