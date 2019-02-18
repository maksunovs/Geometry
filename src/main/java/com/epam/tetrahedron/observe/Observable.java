
package com.epam.tetrahedron.observe;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;

public interface Observable<T extends Tetrahedron> {
        void notifyObserver();
}



