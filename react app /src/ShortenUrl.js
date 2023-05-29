import { useState } from "react";

const ShortenUrl = () => {
    const [longUrl, updateLongUrl] = useState("");
    const [shortUrl, updateShortUrl] = useState("");

    const handlesubmit = (e) => {
        e.preventDefault();
        console.log("long url: ", longUrl);
        fetch("http://localhost:8080/url", {
            method: "POST",
            headers: { "content-type": "application/json" },
            body: JSON.stringify({ "longUrl": longUrl })
        }).then((res) => {
            return res.json();
        }).then((resp) => {
            console.log("short url: ",shortUrl);
            updateShortUrl(resp.shortUrl);
        }).catch((err) => {
            console.log(err.message);
        })
    }

    return (
        <div>
            <div className="container">
                <div className="card">
                    <div className="card-body">
                        <form id="myForm" sclassName="container" onSubmit={handlesubmit}>
                            <div className="row">
                                <table>
                                    <tbody>
                                        <div className="col-lg-12">
                                            <div className="form-group">
                                                <td><label>Enter long URL</label></td>
                                                <td><input value={longUrl} id="myInput" required onChange={e => updateLongUrl(e.target.value)} className="form-control"></input></td>
                                            </div>
                                        </div>
                                    </tbody>
                                </table>
                                <div className="col-lg-12">
                                    <div className="form-group">
                                        <button className="btn btn-success" type="submit">Generate short url</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div className="container">
                    {shortUrl &&
                        <div className="card result">
                            <h4> Short url genarated</h4>
                            <table className="table table-bordered">
                                <tbody>
                                    <tr>
                                        <td>Short Url</td>
                                        <td>{shortUrl}</td>
                                    </tr>
                                    <tr>
                                        <td>Long Url</td>
                                        <td className="overflow-cell">{longUrl}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    }
                </div>
            </div>
        </div>
    );
}
export default ShortenUrl;
