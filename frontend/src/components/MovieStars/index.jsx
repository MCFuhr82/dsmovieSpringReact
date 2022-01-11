import { ReactComponent as StarFull } from 'assets/images/fullstar.svg'
import { ReactComponent as StarHalf } from 'assets/images/halfstar.svg'
import { ReactComponent as StarEmpty } from 'assets/images/emptystar.svg'
import './styles.css'

function MovieStars() {

    return (
        <div className="dsmovie-stars-container">
            <StarFull />
            <StarFull />
            <StarFull />
            <StarHalf />
            <StarEmpty />
        </div>
    );
}

export default MovieStars;