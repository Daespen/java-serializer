//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2021.07.19 um 12:09:30 PM CEST 
//


package org.opcfoundation.ua._2008._02.types;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.kscs.util.jaxb.Buildable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;


/**
 * <p>Java-Klasse für MonitoringFilterResult complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MonitoringFilterResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MonitoringFilterResult")
@XmlSeeAlso({
    EventFilterResult.class,
    AggregateFilterResult.class
})
public class MonitoringFilterResult {


    /**
     * Copies all state of this object to a builder. This method is used by the {@link
     * #copyOf} method and should not be called directly by client code.
     * 
     * @param _other
     *     A builder instance to which the state of this object will be copied.
     */
    public<_B >void copyTo(final MonitoringFilterResult.Builder<_B> _other) {
    }

    public<_B >MonitoringFilterResult.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
        return new MonitoringFilterResult.Builder<_B>(_parentBuilder, this, true);
    }

    public MonitoringFilterResult.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
    }

    public static MonitoringFilterResult.Builder<Void> builder() {
        return new MonitoringFilterResult.Builder<Void>(null, null, false);
    }

    public static<_B >MonitoringFilterResult.Builder<_B> copyOf(final MonitoringFilterResult _other) {
        final MonitoringFilterResult.Builder<_B> _newBuilder = new MonitoringFilterResult.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link
     * #copyOf} method and should not be called directly by client code.
     * 
     * @param _other
     *     A builder instance to which the state of this object will be copied.
     */
    public<_B >void copyTo(final MonitoringFilterResult.Builder<_B> _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
    }

    public<_B >MonitoringFilterResult.Builder<_B> newCopyBuilder(final _B _parentBuilder, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return new MonitoringFilterResult.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public MonitoringFilterResult.Builder<Void> newCopyBuilder(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static<_B >MonitoringFilterResult.Builder<_B> copyOf(final MonitoringFilterResult _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        final MonitoringFilterResult.Builder<_B> _newBuilder = new MonitoringFilterResult.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
    }

    public static MonitoringFilterResult.Builder<Void> copyExcept(final MonitoringFilterResult _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static MonitoringFilterResult.Builder<Void> copyOnly(final MonitoringFilterResult _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    public static class Builder<_B >implements Buildable
    {

        protected final _B _parentBuilder;
        protected final MonitoringFilterResult _storedValue;

        public Builder(final _B _parentBuilder, final MonitoringFilterResult _other, final boolean _copy) {
            this._parentBuilder = _parentBuilder;
            if (_other!= null) {
                if (_copy) {
                    _storedValue = null;
                } else {
                    _storedValue = _other;
                }
            } else {
                _storedValue = null;
            }
        }

        public Builder(final _B _parentBuilder, final MonitoringFilterResult _other, final boolean _copy, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
            this._parentBuilder = _parentBuilder;
            if (_other!= null) {
                if (_copy) {
                    _storedValue = null;
                } else {
                    _storedValue = _other;
                }
            } else {
                _storedValue = null;
            }
        }

        public _B end() {
            return this._parentBuilder;
        }

        protected<_P extends MonitoringFilterResult >_P init(final _P _product) {
            return _product;
        }

        @Override
        public MonitoringFilterResult build() {
            if (_storedValue == null) {
                return this.init(new MonitoringFilterResult());
            } else {
                return ((MonitoringFilterResult) _storedValue);
            }
        }

        public MonitoringFilterResult.Builder<_B> copyOf(final MonitoringFilterResult _other) {
            _other.copyTo(this);
            return this;
        }

        public MonitoringFilterResult.Builder<_B> copyOf(final MonitoringFilterResult.Builder _other) {
            return copyOf(_other.build());
        }

    }

    public static class Select
        extends MonitoringFilterResult.Selector<MonitoringFilterResult.Select, Void>
    {


        Select() {
            super(null, null, null);
        }

        public static MonitoringFilterResult.Select _root() {
            return new MonitoringFilterResult.Select();
        }

    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?> , TParent >
        extends com.kscs.util.jaxb.Selector<TRoot, TParent>
    {


        public Selector(final TRoot root, final TParent parent, final String propertyName) {
            super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
            final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
            products.putAll(super.buildChildren());
            return products;
        }

    }

}
