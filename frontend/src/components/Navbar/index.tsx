import { ReactComponent as GithubIcon } from 'assets/images/logoGithub.svg'
import "./styles.css"

function Navbar() {
    return (
        <header>
            <nav className='container'>
                <div className='bsmovie-nav-content'>
                    <h1>BSMovie</h1>
                    <a href="https://github.com/MCFuhr82">
                        <div className='bsmovie-contact-container'>
                            <GithubIcon />
                            <p className="bsmovie-contact-link">/blinkspace</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;